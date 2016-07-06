package com.sm24soft.entity;

import java.util.Date;
import java.util.List;

public class Invoice extends BaseEntity {

	private String name;
	private String invoiceNumber;
	private String templateNumber;
	private Date dateOfIssue;
	private Store store;
	private Customer customer;
	private Invoice originInvoice;
	
	/*
	 * 0 = Normal Sale, 1 = Return Invoice
	 */
	private String returnedInvoiceFlg;
	
	/*
	 * Tổng giá trị trước thuế
	 */
	private double totalPriceBeforeVAT;
	
	/*
	 * Thuế giá trị gia tăng - VAT Code. Ex: 10%
	 */
	private String valueAddedTax;
	
	/*
	 * Thuế giá trị gia tăng - VAT. Ex: 10%
	 */
	private double totalValueAddedTax;
	
	/*
	 * Tổng giá trị sau thuế
	 */
	private double totalPriceAfterVAT;
	
	/*
	 * Tổng giá trị sau thuế - viết bằng chữ
	 */
	private String totalPriceAfterTaxAsString;
	private Date dateOfSale;
	private Account sellerPerson; // Seller person or Staff
	
	/*
	 * Hình thức thanh toán
	 * 
	 * 1: CASH
	 * 2: BANK
	 * 3: OTHERS
	 */
	private String paymentCode;
	
	/*
	 * Tình trạng thực tế của hoá đơn 
	 * 
	 * 1: WAITING_FOR_CONFIRM, 2: CONFIRMED_AND_WAITING_FOR_SHIP, 3: SHIPPED, 4: CANCELED 
	 * Trường hợp khách hàng ko nhận hàng, hoặc ko thể liên lạc với khách hàng khi ship hàng, etc….
	 */
	private String actualInvoiceStatus;
	private Date expectedDateOfShipping;
	private Date expectedTimeOfShipping;
	
	private List<Invoice> listOfSubInvoices;
	private List<ItemDetail> listOfItemDetails;

	public Invoice() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getTemplateNumber() {
		return templateNumber;
	}

	public void setTemplateNumber(String templateNumber) {
		this.templateNumber = templateNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ItemDetail> getListOfItemDetails() {
		return listOfItemDetails;
	}

	public void setListOfItemDetails(List<ItemDetail> listOfItemDetails) {
		this.listOfItemDetails = listOfItemDetails;
	}

	public Invoice getOriginInvoice() {
		return originInvoice;
	}

	public void setOriginInvoice(Invoice originInvoice) {
		this.originInvoice = originInvoice;
	}

	public String getReturnedInvoiceFlg() {
		return returnedInvoiceFlg;
	}

	public void setReturnedInvoiceFlg(String returnedInvoiceFlg) {
		this.returnedInvoiceFlg = returnedInvoiceFlg;
	}

	public double getTotalPriceBeforeVAT() {
		return totalPriceBeforeVAT;
	}

	public void setTotalPriceBeforeVAT(double totalPriceBeforeVAT) {
		this.totalPriceBeforeVAT = totalPriceBeforeVAT;
	}

	public String getValueAddedTax() {
		return valueAddedTax;
	}

	public void setValueAddedTax(String valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}

	public double getTotalValueAddedTax() {
		return totalValueAddedTax;
	}

	public void setTotalValueAddedTax(double totalValueAddedTax) {
		this.totalValueAddedTax = totalValueAddedTax;
	}

	public double getTotalPriceAfterVAT() {
		return totalPriceAfterVAT;
	}

	public void setTotalPriceAfterVAT(double totalPriceAfterVAT) {
		this.totalPriceAfterVAT = totalPriceAfterVAT;
	}

	public String getTotalPriceAfterTaxAsString() {
		return totalPriceAfterTaxAsString;
	}

	public void setTotalPriceAfterTaxAsString(String totalPriceAfterTaxAsString) {
		this.totalPriceAfterTaxAsString = totalPriceAfterTaxAsString;
	}

	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public Account getSellerPerson() {
		return sellerPerson;
	}

	public void setSellerPerson(Account sellerPerson) {
		this.sellerPerson = sellerPerson;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getActualInvoiceStatus() {
		return actualInvoiceStatus;
	}

	public void setActualInvoiceStatus(String actualInvoiceStatus) {
		this.actualInvoiceStatus = actualInvoiceStatus;
	}

	public Date getExpectedDateOfShipping() {
		return expectedDateOfShipping;
	}

	public void setExpectedDateOfShipping(Date expectedDateOfShipping) {
		this.expectedDateOfShipping = expectedDateOfShipping;
	}

	public Date getExpectedTimeOfShipping() {
		return expectedTimeOfShipping;
	}

	public void setExpectedTimeOfShipping(Date expectedTimeOfShipping) {
		this.expectedTimeOfShipping = expectedTimeOfShipping;
	}

	public List<Invoice> getListOfSubInvoices() {
		return listOfSubInvoices;
	}

	public void setListOfSubInvoices(List<Invoice> listOfSubInvoices) {
		this.listOfSubInvoices = listOfSubInvoices;
	}

}
