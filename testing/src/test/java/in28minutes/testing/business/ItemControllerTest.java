package in28minutes.testing.business;

import in28minutes.testing.model.Item;
import in28minutes.testing.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;


    @Test
    public void dummy_Basic() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\":1,\n" +
                        "  \"name\": \"ball\",\n" +
                        "  \"price\": 10.0,\n" +
                        "  \"quantity\": 100\n" +
                        "}"))
                .andReturn();
    }

    @Test
    public void dummy_Basic_Service() throws Exception{

        when(itemBusinessService.retrieve()).thenReturn(new Item(1,"ball",10 ,100));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json( " { id: 1,name: ball,price: 10,quantity: 100 }"))
                .andReturn();
    }


}
