package io.zipcoder;

import io.zipcoder.controller.TripController;
import io.zipcoder.domain.Trip;
import io.zipcoder.domain.User;
import io.zipcoder.repository.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GrobuxApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class TripControllerTests {

	@InjectMocks
	TripController tripController;

	@Mock
	private TripRepository tripRepository;

	private MockMvc mockMvc;
	private Trip trip;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		trip = new Trip(5L, "Boston", new HashSet<User>());
		mockMvc = standaloneSetup(tripController).build();
	}

	@Test
	public void testGetAllTrips() throws Exception {
		when(tripRepository.findAll()).thenReturn(new ArrayList<Trip>());
		mockMvc.perform(get("/trips"))
				.andExpect(status().isOk())
				.andExpect(content().string("[]"));
	}

	@Test
	public void testGetSingleTrip() throws Exception {
		when(tripRepository.findOne(5L)).thenReturn(trip);
		mockMvc.perform(get("/trips/5"))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"name\":\"Boston\",\"users\":[],\"id\":5}"));
	}

	@Test
	public void testCreateTrip() throws Exception {
		when(tripRepository.save(any(Trip.class))).thenReturn(trip);
		MvcResult result = mockMvc.perform(post("/trips")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"name\": \"Cleveland\", \"users\": [ {\"userName\": \"benedictCumberbatch\"} ]}".getBytes()))
				.andExpect(status().isCreated())
				.andReturn();
		assertTrue(result.getResponse().getHeader("Location").contains("/trips/5"));
	}

	@Test
	public void testModifyTrip() throws Exception {
		when(tripRepository.save(any(Trip.class))).thenReturn(trip);
		mockMvc.perform(put("/trips/5")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"name\": \"Cleveland\", \"users\": [ {\"userName\": \"benedictCumberbatch\"} ]}".getBytes()))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteTrip() throws Exception {
		mockMvc.perform(delete("/trips/5")).andExpect(status().isOk());
	}

}