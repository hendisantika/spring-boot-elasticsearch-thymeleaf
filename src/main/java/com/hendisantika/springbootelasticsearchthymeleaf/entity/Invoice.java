package com.hendisantika.springbootelasticsearchthymeleaf.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elasticsearch-thymeleaf
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/26/23
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
@Document(indexName = "invoices")
@Data
public class Invoice {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Text, name = "number")
    private String number;

    @Field(type = FieldType.Double, name = "amount")
    private Double amount;
}
