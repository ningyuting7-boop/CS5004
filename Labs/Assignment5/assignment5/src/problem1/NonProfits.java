package problem1;

import java.util.ArrayList;

/**
 * Represents a non-profit organization that receives donations.
 * The class stores the organization name and a collection of all
 * donations made to the organization.
 *
 * It also provides functionality to calculate the total donations
 * processed in a specific year.
 */
public class NonProfits {

  /** The name of the non-profit organization. */
  private String name;

  /** A list containing all donations made to the organization. */
  private ArrayList<Donations> allDonations;

  /**
   * Constructs a new NonProfits object with the given name.
   *
   * @param name the name of the non-profit organization
   */
  public NonProfits(String name) {
    this.name = name;
    this.allDonations = new ArrayList<>();
  }

  /**
   * Returns the name of the non-profit organization.
   *
   * @return the organization name
   */
  public String getName(){
    return name;
  }

  /**
   * Returns the list of all donations associated with this organization.
   *
   * @return a list of all donations
   */
  public ArrayList<Donations> getAllDonations(){
    return allDonations;
  }

  /**
   * Updates the name of the non-profit organization.
   *
   * @param newName the new name for the organization
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * Adds a donation to the organization's donation list.
   *
   * @param donation the donation to be added
   */
  public void addDonations(Donations donation){
    allDonations.add(donation);
  }

  /**
   * Calculates the total donation amount processed in a given year.
   * Each donation determines its own contribution for the specified year.
   *
   * @param year the year for which total donations are calculated
   * @return the total amount of donations processed in that year
   */
  public double getTotalDonationsForYear(int year){
    double res = 0;
    for (Donations d: allDonations){
      res += d.getTotalForYear(year);
    }
    return res;
  }
}
