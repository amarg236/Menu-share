package com.menushare.menushare.repo;

import com.menushare.menushare.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepo extends JpaRepository<Menu, Long> {

}
