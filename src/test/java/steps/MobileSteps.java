package steps;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;
import utils.ExcelRead;
import utils.actions;

public class MobileSteps extends actions {
    @When("Read Imei")
    public void read_imei() {
        try {
            ArrayList<String> imeis=ExcelRead.getImei();
            ArrayList<Integer> itemsUsados=new ArrayList<>();
            //get random pos between 0 and imeis size and not contains in itemsUsados
            int pos=(int) (Math.random() * imeis.size());
            while(itemsUsados.contains(pos)) {
                pos=(int) (Math.random() * imeis.size());
            }
            itemsUsados.add(pos);
            System.out.println("Imei: "+imeis.get(pos));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            System.out.println("Error in reading IMEI");
            System.out.println(e.getMessage());
        }
    }
    @When("^Write Imei in text box with id \"([^\"]*)\"$")
    public void writeText(String text,String element){
        By textBy=By.id(element);
        writeText(textBy,text);
    }
    
    @When("^Chick on Bring Your Own Device")
    public void chooseDevice() throws Throwable {
        By chooseDeviceByXPat = By.xpath("//*[@id='root']/div/main/section/section/div[2]/div/div");
        MultipleClick(chooseDeviceByXPat,0);
    }

}
