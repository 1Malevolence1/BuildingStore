package com.example.store.repository;

import com.example.store.model.Store;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {



    @Query(value = "select st.store_name, count(e.employee_id) as employeeCount, sum(p.salary) as totalSalaries from  employee e join  store st on e.store_id = st.store_id join  \"position\" p on e.position_id = p.position_id\n" +
            "group by  st.store_id order by totalSalaries desc", nativeQuery = true)
    List<Tuple> reportReportEmployeeSalariesByPointOfSale();
}
