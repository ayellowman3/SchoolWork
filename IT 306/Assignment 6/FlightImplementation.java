import javax.swing.JOptionPane;
public class FlightImplementation{
     public static void main(String[] args) {
          UnsortedPriorityQueue upq= new UnsortedPriorityQueue();
          String menu = "1 - Add\n2 - Print\n3 - Exit";
          int option =0;
          do{
               option = Integer.parseInt(JOptionPane.showInputDialog(menu));
               switch(option){
                    case 1:
                         boolean connectingFlight = false;
                         long connectionPeriod = PQEntry.DEFAULT_KEY;
                         String FlightNum = JOptionPane.showInputDialog("Enter the flight number");
                         int i = JOptionPane.showConfirmDialog(null, "Is this a connecting flight?",
                              "Is this a connecting flight?", JOptionPane.YES_NO_OPTION);
                         if (i == 0) {
                              connectingFlight = true;
                              connectionPeriod = Integer.parseInt(JOptionPane.showInputDialog("How long is the connection period?"));
                         }
                         else{connectingFlight = false;}
                         
                         addFlight(upq, FlightNum, connectingFlight, connectionPeriod);
                         
                         break;
                    case 2:
                         String out= print(upq);
                         JOptionPane.showMessageDialog(null, out);
                         break;
                    case 3:
                         System.exit(0);
               }
          }while (option!=3);
     }
     
     public static void addFlight(UnsortedPriorityQueue upq, String FlightNum, boolean connectingFlight, long connectionPeriod){
    	 Flight f = new Flight(FlightNum, connectingFlight);
    	 f.setConnectionPeriod(connectionPeriod);
    	 upq.add(f);
     }
     
     public static String print(UnsortedPriorityQueue upq){
    	 String out= "";
    	 
         while(!upq.isEmpty()) {
              out+=upq.removeMin();
              out+= "\n";
         }
         return out;
         
     }
}
