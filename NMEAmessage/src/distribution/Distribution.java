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
                    Utils.print(ms.toString());
                    break;
                }
                case "GLL": {
                    ms=new GLL();
                    ms.getDescription(content);
                    Utils.print(ms.toString());
                    break;
                }
                case "RMC": {
                    ms=new RMC();
                    ms.getDescription(content);
                    Utils.print(ms.toString());
                    break;
                }
                case "VTG": {
                    ms=new VTG();
                    ms.getDescription(content);
                    Utils.print(ms.toString());
                    break;
                }
                case "GGA": {
                    ms=new GGA();
                    ms.getDescription(content);
                    Utils.print(ms.toString());
                    break;
                }
                case "GSA": {
                    ms=new GSA();
                    ms.getDescription(content);
                    Utils.print(ms.toString());
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
