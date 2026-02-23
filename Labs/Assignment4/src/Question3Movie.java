class Question3Movie {

  public static void main(String[] args) {
    ActionMovie killbill2 = new ActionMovie(0, "Kill Bill: Volume 2", "R");
    ComedyMovie meangirls = new ComedyMovie(1, "Mean Girls", "PG-13");
    DramaMovie mystic = new DramaMovie(2, "Mystic River", "R");
    DramaMovie mysticCopy2 = new DramaMovie(2, "Mystic River, Second Copy", "R");
    System.out.println("If " + killbill2.getTitle() + " is 2 days late the fee is " +
        killbill2.calcLateFees(2));
    // If Kill Bill: Volume 2 is 2 days late the fee is 6.0
    System.out.println("If " + killbill2.getTitle() + " is 3 days late the fee is " +
        killbill2.calcLateFees(3));
    // If Kill Bill: Volume 2 is 3 days late the fee is 9.0
    System.out.println("If " + meangirls.getTitle() + " is 3 days late the fee is " +
        meangirls.calcLateFees(3));
    // If Mean Girls: is 3 days late the fee is 7.5
    System.out.println("If " + mystic.getTitle() + " is 3 days late the fee is " +
        mystic.calcLateFees(3));
    // If Mystic River is 3 days late the fee is 6.0
    System.out.println("Is " + killbill2.getTitle() + " equal " + mystic.getTitle() +
        "? " + killbill2.equals(mystic));
    // Is Kill Bill: Volume 2 equal Mystic River? false
    System.out.println("Is " + meangirls.getTitle() + " equal " + mystic.getTitle() +
        "? " + meangirls.equals(mystic));
    // Is Mean Girls equal Mystic River? false
    System.out.println("Is " + mystic.getTitle() + " equal " + mysticCopy2.getTitle() +
        "? " + mystic.equals(mysticCopy2));
    // Is Mystic River equal Mystic River, Second Copy? true
  }

}
