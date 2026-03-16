package problem1;

import java.time.LocalDateTime;

/**
 * Abstract base class representing a donation made to a non-profit organization.
 * All donations have a monetary amount and a creation date/time.
 * Subclasses implement different donation behaviors such as
 * one-time donations, monthly donations, and pledges.
 */
public abstract class Donations {

  /** The amount of money donated. */
  protected double amount;

  /** The date and time when the donation was created. */
  protected LocalDateTime creationDateTime;

  /**
   * Constructs a new Donation.
   *
   * @param amount the amount of the donation
   * @param creationDateTime the date and time the donation was created
   */
  public Donations(double amount, LocalDateTime creationDateTime) {
    this.amount = amount;
    this.creationDateTime = creationDateTime;
  }

  /**
   * Returns the amount of this donation.
   *
   * @return the donation amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns the creation date and time of the donation.
   *
   * @return the creation date/time
   */
  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  /**
   * Calculates the total donation amount contributed in a given year.
   * The calculation depends on the specific type of donation.
   *
   * @param year the year for which the total donation is calculated
   * @return the total amount contributed in that year
   */
  public abstract double getTotalForYear(int year);
}

