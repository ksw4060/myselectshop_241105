package com.example.mySelectShop.demo.repository;

import com.example.mySelectShop.demo.entity.Folder;
import com.example.mySelectShop.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    // select * from folder where user_id = ? and name in (?, ?, ?); 이렇게
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);

    List<Folder> findAllByUser(User user);
}
