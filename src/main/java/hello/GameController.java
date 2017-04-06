package hello;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    //Startar länderna utanför för att skriva om länderna hela tiden
    Board createInitBoard = new Board();
    List<Region> activeGameBoard = createInitBoard.getRegions();
    List<MajorNation> majorNations = new ArrayList<>();
    MajorNation britain = new MajorNation("BRITAIN");
    MajorNation germany = new MajorNation("GERMANY");
    MajorNation france = new MajorNation("FRANCE");
    MajorNation usa = new MajorNation("USA");
    MajorNation japan = new MajorNation("JAPAN");
    MajorNation russia = new MajorNation("RUSSIA");
    String activeCountry = "usa";

    @GetMapping("/map")
    public ModelAndView map(HttpSession session) {
        initMajorNationsList();
        ModelAndView mapmodel = new ModelAndView("map");
        if (session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/index.html");
        }
        return mapmodel;
    }

    @MessageMapping("/makeMove")
    @SendTo("/topic/gameRoom")
    public RegionInfo region(String regionIdObject) throws Exception {
        System.out.println(regionIdObject);
        JSONParser myJsonParser = new JSONParser();
        JSONObject myJson = (JSONObject) myJsonParser.parse(regionIdObject);
        //System.out.println(myJson.get("name"));
        //System.out.println(myJson.get("majorNationTurn"));
        //Vi använder teckenkombination !1 för att kunna använda split i Javascript och dela upp

        String gID = ((String) myJson.get("name")).substring(1);
        String majorNationTurn = (String) myJson.get("majorNationTurn");
        int gInt = Integer.parseInt(gID)-1;
        String namesOfAttackRegions = "";
        String idsForAdjacentRegions = "";
        String currentLand = activeGameBoard.get(gInt).getName() + " !1Troops " + activeGameBoard.get(gInt).getTroops() + " <br>Networth " + activeGameBoard.get(gInt).getNetworth();

        switch (majorNationTurn) {
            case "Britain":
                System.out.println(majorNationTurn);
                break;
            case "Germany":
                System.out.println(majorNationTurn);
                break;
            case "France":
                System.out.println(majorNationTurn);
                break;
            case "Usa":
                System.out.println(majorNationTurn);
                break;
            case "Japan":
                System.out.println(majorNationTurn);
                break;
            case "Russia":
                System.out.println(majorNationTurn);
                break;
        }

        for (String adjacent : activeGameBoard.get(gInt).getAdjacentRegions()) {
            idsForAdjacentRegions +="!3"+ adjacent;
        }
        idsForAdjacentRegions +="!3"+ myJson.get("name");
        return new RegionInfo(currentLand, namesOfAttackRegions, idsForAdjacentRegions);
    }

    public void initMajorNationsList() {
        if (britain != null){
            majorNations.add(britain);
        }
        if (germany != null){
            majorNations.add(germany);
        }
        if (france != null){
            majorNations.add(france);
        }
        if (usa != null){
            majorNations.add(usa);
        }
        if (japan != null){
            majorNations.add(japan);
        }
        if (russia != null){
            majorNations.add(russia);
        }
    }
}
