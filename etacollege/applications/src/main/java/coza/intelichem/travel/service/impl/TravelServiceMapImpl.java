package coza.intelichem.travel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import coza.intelichem.travel.Itinerary;
import coza.intelichem.travel.service.TravelService;

@Default
@Singleton
public class TravelServiceMapImpl implements TravelService {

    private Map<String, Itinerary> itineraries = new HashMap<String, Itinerary>();

    @Override
    public Itinerary getItineraryById(String id) {
	if (itineraries.containsKey(id)) {
	    return itineraries.get(id);
	}
	return null;
    }

    @Override
    public void insertItinerary(Itinerary itinerary) throws Exception {
	// Set new id if it is null.
	if (itinerary.getId() == null) {
	    itinerary.setId(UUID.randomUUID().toString());
	}

	// Check if id does not already exist.
	if (itineraries.containsKey(itinerary.getId())) {
	    throw new Exception("Person already exists for id " + itinerary.getId());
	}
	itineraries.put(itinerary.getId(), itinerary);
    }

    @Override
    public void updateItinerary(Itinerary itinerary) throws Exception {
	if (!itineraries.containsKey(itinerary.getId())) {
	    throw new Exception("Person does not exist for id " + itinerary.getId());
	}
	itineraries.put(itinerary.getId(), itinerary);

    }

    @Override
    public void deleteItinerary(String id) throws Exception {
	if (!itineraries.containsKey(id)) {
	    throw new Exception("Person does not exist for id " + id);
	}
	itineraries.remove(id);
    }

    @Override
    public List<Itinerary> searchItineraries(String applicantId) throws Exception {
	List<Itinerary> searchResults = new ArrayList<Itinerary>();
	for (Itinerary itinerary : itineraries.values()) {
	    if (applicantId != null) {
		if (itinerary.getApplicantId().equals(applicantId)) {
		    searchResults.add(itinerary);
		}
	    }
	}
	return searchResults;
    }

}
