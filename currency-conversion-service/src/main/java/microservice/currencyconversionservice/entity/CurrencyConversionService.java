package microservice.currencyconversionservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currency_conversion")
public class CurrencyConversionService {
    @Id
    private Long id;

    @Column(name = "currency_conversion_from")
    private String from;

    @Column(name = "currency_conversion_to")
    private String to;

    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;

    @Column(name = "total_calculated_amount")
    private BigDecimal totalCalculatedAmount;

    @Column(name = "quantity")
    private BigDecimal quantity ;

    @Column(name = "port")
    private int port ;


}
