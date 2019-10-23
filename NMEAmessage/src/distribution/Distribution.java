package distribution;

import distribution.classes.*;

public class Distribution {
    public void getDescription(String message) {
        String head = message.substring(1, message.indexOf(","));
        if (head.length() == 5) {
            head = head.substring(2);
            String[] content = message.substring(message.indexOf(",") + 1).split(",");
            content[content.length - 1] = content[content.length - 1].substring(0, content[content.length- 1].indexOf('*'));
            GpsMessages ms;
            switch (head) {
                case "GSV": {
                    ms=new GSV();
                    ms.getDescription(content);
                    break;
                }
                case "GLL": {
                    ms=new GLL();
                    ms.getDescription(content);
                    break;
                }
                case "RMC": {
                    ms=new RMC();
                    ms.getDescription(content);
                    break;
                }
                case "VTG": {
                    ms=new VTG();
                    ms.getDescription(content);
                    break;
                }
                case "GGA": {
                    ms=new GGA();
                    ms.getDescription(content);
                    break;
                }
                case "GSA": {
                    ms=new GSA();
                    ms.getDescription(content);
                    break;
                }
                default: {
                    System.out.println("Not NMEA message or no defined method to read.");
                    break;
                }
            }
        }else {
            System.out.println("Not NMEA message.");
        }

    }

}
