package edu.iu.c322.assetmanagement.assetservice.repository;

import edu.iu.c322.assetmanagement.licensingservice.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
