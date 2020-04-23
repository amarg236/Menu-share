package com.menushare.menushare.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.zxing.*;
import com.google.zxing.Reader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.menushare.menushare.dto.response.MenuResponse;
import com.menushare.menushare.model.Menu;
import com.menushare.menushare.model.MenuRequest;
import com.menushare.menushare.service.MenuService;
import com.menushare.menushare.service.QrCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MenuController {

    private final MenuService menuService;
    private final QrCodeService qrCodeService;

    @RequestMapping("/getMenu")
    public List<Menu> getMenuItem(){
        return menuService.getMenu();
    }

    @PostMapping("/createMenu")
    public MenuRequest createMenu(@RequestBody MenuRequest menuRequest){
        menuService.createMenu(menuRequest);
        return menuRequest;
    }


    @GetMapping("/decodeQrCode/{qrNumber}")
    public ResponseEntity<Menu> decodeQrCode(@PathVariable String qrNumber) {
        Menu menu = qrCodeService.decode(qrNumber);
        return ResponseEntity.status(HttpStatus.OK).body(menu);
    }

    @GetMapping(value="/generateQrCode/{menuId}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQRCodeImage(@PathVariable Long menuId) throws Exception {
        Menu menu = menuService.findMenu(menuId);
        String qrImagePath = "./src/main/resources/qr_images/" + menu.getItemName()  + ".png";
        log.info(qrImagePath);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(menu.json().trim(), BarcodeFormat.QR_CODE, 200, 200);

        Path path = FileSystems.getDefault().getPath(qrImagePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;

//        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    @GetMapping(value="/readQrCode", consumes = {"multipart/form-data"})
    public ResponseEntity<MenuResponse> readQrCodeImage(@RequestPart("file") MultipartFile file) throws IOException, FormatException, ChecksumException, NotFoundException {
        InputStream barCodeInputStream = file.getInputStream();
        BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);

        LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new MultiFormatReader();
        Result result = reader.decode(bitmap);

        log.info(String.valueOf(result));

        JsonObject jsonObject = new JsonParser().parse(result.toString()).getAsJsonObject();
        System.out.println("Barcode json is " + jsonObject);

        MenuResponse menuResponse = new MenuResponse(jsonObject.get("itemName").toString(),
                                                     jsonObject.get("itemDescription").toString(),
                                                     jsonObject.get("itemPrice").getAsLong());


        return ResponseEntity.status(HttpStatus.OK).body(menuResponse);

    }






}
