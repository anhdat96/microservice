package microservice.currencyexchangeservice.repository;

import microservice.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByExchangeFromAndExchangeTo(String from,String to);
}
