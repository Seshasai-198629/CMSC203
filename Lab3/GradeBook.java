package application;

import java.util.ArrayList;

public class GradeBook
{
   private double[] scores;
   private int scoresSize;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }

   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore()
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }

   /**
    * Returns the total amount of scores stored in the array
    * @author github.com/amattu2
    * @return (Int) Amount of scores stored
    */
   public int getScoreSize() {
	   return this.scoresSize;
   }

   /**
    * Returns a stringified version of the Gradebook
    * @author github.com/amattu2
    * @return (String) Gradebook scores
    */
   public String toString() {
	   // Variables
	   String stringified = "";

	   // Loops
	   for (int i = 0; i < this.scoresSize; i++) {
		   // Checks
		   if (this.scores[i] < 0.0) { continue; }
		   stringified += (i == 0 ? "" : " ") + this.scores[i];
	   }

	   // Return
	   return stringified;
   }
}