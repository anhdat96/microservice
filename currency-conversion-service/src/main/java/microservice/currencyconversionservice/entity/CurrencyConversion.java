package microservice.currencyconversionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.common.util.StringHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "currency_conversion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    @Id
    private long id;

    @Column(name = "conversion_from")
    private String from;

    @Column(name="conversion_to")
    private String to;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name="total_calculated_amount")
    private BigDecimal totalCalculatedAmount;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name = "port")
    private int port;
}
