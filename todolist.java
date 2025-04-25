import java.util.*;
public class todolist{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks=new ArrayList<>();
        while (true) { 
            System.out.println("\n --------TO DO LIST-------");
            System.out.println("1.Add your Task");
            System.out.println("2.view your Task");
            System.out.println("3.Remove your Task");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            sc.nextLine();
        switch(choice){
            case 1:
            System.out.print("Add your task");
            String task=sc.nextLine();
            tasks.add(task);
            System.out.println("Task Added");
            break;

            case 2:
            System.out.println("Your task");
            if(tasks.isEmpty()){
                System.out.println("Nothing Added yet");
            }
            else{
                for(int i=0;i<tasks.size();i++){
                   System.out.println((i+1)+"."+ tasks.get(i));
                }
            }

            case 3:
            System.out.print("Enter task number to remove: ");
            int index = sc.nextInt();
            if(index>0 && index<tasks.size()){
                tasks.remove(index-1);
                System.out.println("your task removed");
            }
            else{
                System.out.println("Invalid input");
            }

            case 4:
            System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
        }
    }
    }
}