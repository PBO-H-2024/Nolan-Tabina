/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Score;
/**
 *
 * @author Widows
 */
public class Result {
    private String name;
    private double weight;
    
    public Result(String name, double weight){
        this.name = name;
        this.weight = weight;
    }
    
    public String getName(){
        return name;
    }
    
    public String getWeight(){
        return weight;
    }
    
    public static Result[] getResult(String type){
        if(type.equalsIgnoreCase("android")){
            return new Result[]{new Result("Bobot Writing", 0.2), new Result("Bobot Coding", 0.5), new Result("Bobot Interview", 0.3)};
        }else if(type.equalsIgnoreCase("android")){
            return new Result[]{new Result("Bobot Writing", 0.4), new Result("Bobot Coding", 0.35), new Result("Bobot Interview", 0.25)};
        }else{
            return new Result[0];
        }
    }
}
