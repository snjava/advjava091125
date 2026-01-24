package com.learning.respository;

import com.learning.entity.Product;
import com.learning.entity.UserBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBillRepository  extends JpaRepository<UserBill, Integer> {
}
