package com.productapp.ProductService.models.orders;


import com.productapp.ProductService.models.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {
}
