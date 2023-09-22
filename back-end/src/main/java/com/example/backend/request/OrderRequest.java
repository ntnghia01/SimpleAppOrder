package com.example.backend.request;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import lombok.Data;

@Data
public class OrderRequest {
    private List<Item> items;
    private Address billing;
    private Consumer consumer;
    private Merchant merchant;
    private Address shipping;
    private List<Discount> discounts;
    private Amount taxAmount;
    private Amount totalAmount;
    private Amount shippingAmount;
    private String merchantReference;
    private String type;
    private String product;
    private Frequency frequency;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Address getBilling() {
        return billing;
    }

    public void setBilling(Address billing) {
        this.billing = billing;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Address getShipping() {
        return shipping;
    }

    public void setShipping(Address shipping) {
        this.shipping = shipping;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Amount getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Amount taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Amount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Amount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Amount getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Amount shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
