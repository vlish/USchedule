package com.softserveinc.uschedule.repository;

import com.softserveinc.uschedule.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
