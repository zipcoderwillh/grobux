package io.zipcoder;

import io.zipcoder.controller.TripController;
import io.zipcoder.domain.Trip;
import io.zipcoder.repository.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
	public void testCreateTrip() throws Exception {
		Trip added = new Trip();
		when(tripRepository.save(added)).thenReturn(added);
		mockMvc.perform(post("/trips").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Akron\",\"users\":[{\"userName\":\"benedictCumberbatch\"}]\"}")).andExpect(status().isCreated());
	}

}