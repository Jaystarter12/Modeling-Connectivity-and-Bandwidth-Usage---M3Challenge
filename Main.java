class Main{
  // Selects an activity at the current instant and determines the Mbps for that particular activity
  public static double activityCalculation(double[] chances){

    // Initializes the chance that a particular activity occurs
    double chance1 = chances[0] / (chances[0] + chances[1] + chances[2] + chances[3]);

    double chance2 = chances[1] / (chances[0] + chances[1] + chances[2] + chances[3]) + chance1;

    double chance3 = chances[2] / (chances[0] + chances[1] + chances[2] + chances[3]) + chance2;

    double chance4 = chances[3] / (chances[0] + chances[1] + chances[2] + chances[3]) + chance3;

    double random=Math.random();

    if(random >= 0 && random < chance1){
      return 1;
    }else if(random >= chance1 && random < chance2){
      return 3;
    }else if(random >= chance2 && random < chance3){
      return 4;
    }
      return 8;
  }

  // Method runs a monteCarlo simulation for all 3 individuals
  public static double monteCarlo(double[] person1, double[] person2, double[] person3, double runs) {
      
      double accum = 0;

      for(int i = 0; i < runs; i++) {
          accum += (activityCalculation(person1) + activityCalculation(person2) + activityCalculation(person3));
      }

      return accum / runs;
  }

  public static void main(String[] args) {
    // SCENARIO 1 CALCULATIONS

    // 3-year-old child
    double[] person1 = new double[]{0, 2.92, 0, 5.55};

    // Jobless 30-year-old
    double[] person2 = new double[]{24.69,3.73,4.35,6.2};
    // 6.2 derived from TV connected internet and video on computer (see assumptions regarding HD), 4.35 from 2.50 + 0.7 + 1.05 + 0.10 (see assumptions for SD mobile), 24.69 derived from 24.67+ 4.37 - 4.35(general web surfing minus video watching) 

    // 30-year-old teacher
    double[] person3 = new double[]{28.14,5.34,0,6.21};
    //Uses 3rd quarter 2015 income category, teacher makes 50-75k annually (added pc browsing and mobile browsing to get 28.14)

    
    double runs = 10000;
    //System.out.println(monteCarlo(person1, person2, person3, runs));

    double average = monteCarlo(person1, person2, person3, runs);
    double success = 0;
    int counter;

    // Heavily Modified Monte Carlo #1
    while(success <= 99){

      counter = 0;

      for(int i = 0; i < runs; i++){
        
        if(activityCalculation(person1) + activityCalculation(person2) + activityCalculation(person3) <= average){

          counter++;

        }
      }
      success = counter / runs * 100.0;
      if(success < 99)
        average += 1;
    }
    System.out.println(success);
    System.out.println(average);

    
    // SCENARIO 2 CALCULATIONS

    // Grandmother in her 70s caring for two.
    double[] person4 = new double[]{21.80,0.15,1.46,2.40};

    // Grandchild 1.
    double[] person5 = new double[]{0,4.08,0,3.43};

    // Grandchild 2.
    double[] person6 = new double[]{0,4.08,0,3.43};

    average = monteCarlo(person4, person5, person6, runs);
    success = 0;

    // Heavily Modified Monte Carlo #1
    while(success <= 99){

      counter = 0;

      for(int i = 0; i < runs; i++){
        
        if(activityCalculation(person4) + activityCalculation(person5) + activityCalculation(person6) <= average){

          counter++;

        }
      }
      success = counter / runs * 100.0;
      if(success < 99)
        average += 1;
    }
    //System.out.println(success);
    //System.out.println(average);




    // SCENARIO 3 CALCULATIONS
    
    // 3 former M3C undergrads (full) and working (part)
    double[] person7 = new double[]{31.99,9.89,0,9.14};
    double[] person8 = new double[]{31.99,9.89,0,9.14};
    double[] person9 = new double[]{31.99,9.89,0,9.14};

    average = monteCarlo(person7, person8, person9, runs);
    success = 0;

    // Heavily Modified Monte Carlo #1
    while(success <= 99){

      counter = 0;

      for(int i = 0; i < runs; i++){
        
        if(activityCalculation(person7) + activityCalculation(person8) + activityCalculation(person9) <= average){

          counter++;

        }
      }
      success = counter / runs * 100.0;
      if(success < 99)
        average += 1;
    }
    System.out.println(success);
    System.out.println(average);
  }
  
}
