package com.sb.unittesting.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.unittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
