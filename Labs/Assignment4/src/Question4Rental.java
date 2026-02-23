class Question4Rental {

  private Rental[] rentals;

  public Question4Rental(int numRentals) {
    rentals = new Rental[numRentals];
  }

  public void setRental(Rental rental, int index) {
    this.rentals[index] = rental;
  }

  public Rental[] getRentals() {
    return this.rentals;
  }

  public double lateFeesOwed() {
    double amount = 0;
    for (int i = 0; i < rentals.length; i++) {
      amount += rentals[i].getLateFees();
    }
    return amount;
  }

  public static void main(String[] args) {
    ActionMovie killbill2 = new ActionMovie(0, "Kill Bill: Volume 2", "R");
    ComedyMovie meangirls = new ComedyMovie(1, "Mean Girls", "PG-13");
    DramaMovie mystic = new DramaMovie(2, "Mystic River", "R");
    Question4Rental JoesRentals = new Question4Rental(3);
    Rental rental1 = new Rental(killbill2, 1);
    Rental rental2 = new Rental(meangirls, 1);
    Rental rental3 = new Rental(mystic, 1);
    JoesRentals.setRental(rental1, 0);
    JoesRentals.setRental(rental2, 1);
    JoesRentals.setRental(rental3, 2);
    rental1.setDaysLate(2);
    rental2.setDaysLate(2);
    rental3.setDaysLate(2);
    System.out.println("With each movie 2 days late the late fees are " +
        JoesRentals.lateFeesOwed());
  }
}
