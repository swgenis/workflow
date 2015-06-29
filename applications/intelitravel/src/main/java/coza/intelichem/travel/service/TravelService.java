package coza.intelichem.travel.service;

import java.util.List;

import coza.intelichem.travel.Itinerary;

/**
 * CRUD Service to persist leave records.
 * 
 * @author SW Genis
 * 
 */
public interface TravelService {

    /**
     * 
     * @param id
     * @return
     */
    Itinerary getItineraryById(String id);

    /**
     * 
     * @param itinerary
     * @throws Exception
     */
    void insertItinerary(Itinerary itinerary) throws Exception;

    /**
     * 
     * @param itinerary
     * @throws Exception
     */
    void updateItinerary(Itinerary itinerary) throws Exception;

    /**
     * 
     * @param id
     * @throws Exception
     */
    void deleteItinerary(String id) throws Exception;

    /**
     * 
     * @param personId
     * @return
     * @throws Exception
     */
    List<Itinerary> searchItineraries(String personId) throws Exception;

}
