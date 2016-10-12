package be.insaneprogramming.cleanarch.interactor;

import be.insaneprogramming.cleanarch.boundary.CreateBuilding;
import be.insaneprogramming.cleanarch.entity.Building;
import be.insaneprogramming.cleanarch.entity.BuildingFactory;
import be.insaneprogramming.cleanarch.entitygateway.BuildingEntityGateway;
import be.insaneprogramming.cleanarch.requestmodel.CreateBuildingRequest;

public class CreateBuildingImpl implements CreateBuilding {
	private BuildingEntityGateway buildingEntityGateway;
	private BuildingFactory buildingFactory;

	public CreateBuildingImpl(BuildingEntityGateway buildingEntityGateway, BuildingFactory buildingFactory) {
		this.buildingEntityGateway = buildingEntityGateway;
		this.buildingFactory = buildingFactory;
	}

	@Override
	public String execute(CreateBuildingRequest request) {
		if(request == null) {
			throw new IllegalArgumentException("request should not be null");
		}
		Building building = buildingFactory.createBuilding(request.getName());
		return buildingEntityGateway.save(building);
	}
}
