package edu.iu.c322.assetmanagement.assetservice.controller;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetRepository repository;
    private final AssetClient assetClient;

    public AssetController(AssetRepository repository, AssetClient assetClient) {
        this.repository = repository;
        this.assetClient = assetClient;
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Asset getAsset(@PathVariable int id) {
        Optional<Asset> maybeAsset = repository.findById(id);
        if (maybeAsset.isPresent()) {
            Asset asset = maybeAsset.get();
            License license = assetClient.getLicense(asset.getLicenseId());
            asset.setLicenseType(license.getLicenseType());
            asset.setLicenseDescription(license.getDescription());
            return asset;
        } else {
            throw new IllegalStateException("asset id is invalid.");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Asset asset) {
        Asset addedAsset = repository.save(asset);
        return addedAsset.getId();
    }
}