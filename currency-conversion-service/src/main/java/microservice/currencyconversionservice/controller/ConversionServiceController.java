package microservice.currencyconversionservice.controller;

import microservice.currencyconversionservice.entity.CurrencyConversion;
import microservice.currencyconversionservice.service.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversionServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;


    public static final String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable  BigDecimal quantity
    ){

        Map<String,String> uriVariable = new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);
        ResponseEntity<CurrencyConversion> responseEntity= new RestTemplate().getForEntity(url,CurrencyConversion.class,uriVariable);

        CurrencyConversion currencyConversion = new CurrencyConversion();
        currencyConversion.setFrom(from);
        currencyConversion.setTo(to);
        currencyConversion.setId(responseEntity.getBody().getId());
        currencyConversion.setConversionMultiple(responseEntity.getBody().getConversionMultiple());
        currencyConversion.setPort(responseEntity.getBody().getPort());
        currencyConversion.setQuantity(quantity);

        // result after calculated
        currencyConversion.setTotalCalculatedAmount(quantity.multiply(responseEntity.getBody().getConversionMultiple()));
        return currencyConversion;
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyFeign(@PathVariable String from,
                                              @PathVariable String to,
                                              @PathVariable  BigDecimal quantity
    ){
        // feign
        CurrencyConversion currencyConversionUseFeign = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);

        logger.info(" {} ", currencyConversionUseFeign);

        currencyConversionUseFeign.setFrom(from);
        currencyConversionUseFeign.setTo(to);
        currencyConversionUseFeign.setId(currencyConversionUseFeign.getId());
        currencyConversionUseFeign.setConversionMultiple(currencyConversionUseFeign.getConversionMultiple());
        currencyConversionUseFeign.setPort(currencyConversionUseFeign.getPort());
        currencyConversionUseFeign.setQuantity(quantity);

        currencyConversionUseFeign.setTotalCalculatedAmount(quantity.multiply(currencyConversionUseFeign.getConversionMultiple()));
        return currencyConversionUseFeign;
    }
}
