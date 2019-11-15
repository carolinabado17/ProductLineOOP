package sample;

import java.util.Date;

/**
 * Holds the Production Record of the Products.
 *
 * @author carolinabado
 */
public class ProductionRecord {

  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public int getProductID() {
    return productID;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }

  public Date getProdDate() {
    return new Date();
  }

  ProductionRecord(int productID) {
    productionNumber = 0;
    serialNumber = "0";
    // set date to current date using new Date()
    dateProduced = new Date();
  }

  /**
   * Overloaded Constructor for the ProductionRecord.
   *
   * @param productionNumber number that is produced. How many products are being produced
   * @param productID Number Identification of the product
   * @param serialNumber serial number of the product
   * @param dateProduced date that the product is produced
   */
  ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }

  /**
   * Composing the serial number for the product. uses the first 3 letters of manufacturer, followed
   * by the label of ItemType
   *
   * @param product the product
   * @param numProduced keeps track of the amount of products made
   */
  ProductionRecord(Product product, int numProduced) {

    String idNum = String.format("%05d", numProduced);
    this.serialNumber =
        product.getManufacturer().substring(0, 3) + product.getType().getLabel() + idNum;
    this.dateProduced = new Date();
  }
}
