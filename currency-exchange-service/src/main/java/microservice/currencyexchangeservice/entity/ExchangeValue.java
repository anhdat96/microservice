package microservice.currencyexchangeservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "exchange_service")
public class ExchangeValue {

    @Id
    @Column(name= "id")
    private Long id;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    @Column(name = "port")
    private int port;

    public ExchangeValue() {

    }

    public ExchangeValue(Long id, BigDecimal conversionMultiple, String from, String to, int port) {
        this.id = id;
        this.conversionMultiple = conversionMultiple;
        this.from = from;
        this.to = to;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
