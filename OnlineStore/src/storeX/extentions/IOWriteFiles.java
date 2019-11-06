package storeX.extentions;

import goods.categoris.*;
import logger.LogType;
import logger.Logger;
import storeX.StoreX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class IOWriteFiles {
    private static IOWriteFiles instance;

    public static IOWriteFiles getInstance() {
        if (instance == null) {
            return new IOWriteFiles();
        }
        return instance;
    }

    public void close(StoreX storeX) {
        wrightBalance(storeX.getBalance(), new File(Pathes.BALANCE));
        wrightPhones(storeX.getPhones(), new File(Pathes.PHONES));
        wrightComputers(storeX.getComputers(), new File(Pathes.COMPUTERS));
        wrightVegetables(storeX.getVegetables(), new File(Pathes.VEGETABLES));
        wrightSweets(storeX.getSweets(), new File(Pathes.SWEETS));
        wrightFreshWaters(storeX.getFreshWaters(), new File(Pathes.FRESHWATER));
        wrightSweetWaters(storeX.getSweetWaters(), new File(Pathes.SWEETWATER));
        wrightClothes(storeX.getClothes(), new File(Pathes.CLOTHES));
    }

    private void wrightClothes(Clothes[] clothes, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(clothes.length + "\n");
            for (int i = 0; i < clothes.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Id =" + clothes[i].getId());
                writer.write(clothes[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Name =" + clothes[i].getName());
                writer.write(clothes[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Amount =" + clothes[i].getAmount());
                writer.write(clothes[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Description =" + clothes[i].getDescription());
                writer.write(clothes[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Price =" + clothes[i].getPrice());
                writer.write(clothes[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes[i].getBrend().getBrandFoundationYear() =" + clothes[i].getBrend().getBrandFoundationYear());
                writer.write(clothes[i].getBrend().getBrandFoundationYear() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Brend.BrandName =" + clothes[i].getBrend().getBrandName());
                writer.write(clothes[i].getBrend().getBrandName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Brend.BrandEmployeesNumber =" + clothes[i].getBrend().getBrandEmployeesNumber());
                writer.write(clothes[i].getBrend().getBrandEmployeesNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: clothes.Brend.BrandSellCountiesNumber =" + clothes[i].getBrend().getBrandSellCountiesNumber());
                writer.write(clothes[i].getBrend().getBrandSellCountiesNumber() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightSweetWaters(SweetWater[] sweetWaters, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(sweetWaters.length + "\n");
            for (int i = 0; i < sweetWaters.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.Id =" + sweetWaters[i].getId());
                writer.write(sweetWaters[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.Name =" + sweetWaters[i].getName());
                writer.write(sweetWaters[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.Amount =" + sweetWaters[i].getAmount());
                writer.write(sweetWaters[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.Description =" + sweetWaters[i].getDescription());
                writer.write(sweetWaters[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.Price =" + sweetWaters[i].getPrice());
                writer.write(sweetWaters[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.ProductionDate.YEAR =" + sweetWaters[i].getExpirationTime().getProductionDate().get(Calendar.YEAR));
                writer.write(sweetWaters[i].getExpirationTime().getProductionDate().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.ProductionDate.MONTH =" + sweetWaters[i].getExpirationTime().getProductionDate().get(Calendar.MONTH));
                writer.write(sweetWaters[i].getExpirationTime().getProductionDate().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.ProductionDate.DAY_OF_MONTH =" + sweetWaters[i].getExpirationTime().getProductionDate().get(Calendar.DAY_OF_MONTH));
                writer.write(sweetWaters[i].getExpirationTime().getProductionDate().get(Calendar.DAY_OF_MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.SaveTemperature) =" + sweetWaters[i].getExpirationTime().getSaveTemperature());
                writer.write(sweetWaters[i].getExpirationTime().getSaveTemperature() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.ExpirationTime.YEAR =" + sweetWaters[i].getExpirationTime().getExpirationTime().get(Calendar.YEAR));
                writer.write(sweetWaters[i].getExpirationTime().getExpirationTime().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.ExpirationTime.MONTH =" + sweetWaters[i].getExpirationTime().getExpirationTime().get(Calendar.MONTH));
                writer.write(sweetWaters[i].getExpirationTime().getExpirationTime().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweetWaters.ExpirationTime.DAY_OF_MONTH =" + sweetWaters[i].getExpirationTime().getExpirationTime().get(Calendar.DAY_OF_MONTH));
                writer.write(sweetWaters[i].getExpirationTime().getExpirationTime().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightFreshWaters(FreshWater[] freshWaters, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(freshWaters.length + "\n");
            for (int i = 0; i < freshWaters.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: freshWaters.Id =" + freshWaters[i].getId());
                writer.write(freshWaters[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: freshWaters.Name =" + freshWaters[i].getName());
                writer.write(freshWaters[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: freshWaters.Amount =" + freshWaters[i].getAmount());
                writer.write(freshWaters[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: freshWaters.Description =" + freshWaters[i].getDescription());
                writer.write(freshWaters[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: freshWaters.Price =" + freshWaters[i].getPrice());
                writer.write(freshWaters[i].getPrice() + "\n");
                }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightSweets(Sweets[] sweets, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(sweets.length + "\n");
            for (int i = 0; i < sweets.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.Id =" + sweets[i].getId());
                writer.write(sweets[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.Name =" + sweets[i].getName());
                writer.write(sweets[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.Amount =" + sweets[i].getAmount());
                writer.write(sweets[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.Description =" + sweets[i].getDescription());
                writer.write(sweets[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.Price =" + sweets[i].getPrice());
                writer.write(sweets[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.ProductionDate.YEAR =" + sweets[i].getExpirationTime().getProductionDate().get(Calendar.YEAR));
                writer.write(sweets[i].getExpirationTime().getProductionDate().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.ProductionDate.MONTH =" + sweets[i].getExpirationTime().getProductionDate().get(Calendar.MONTH));
                writer.write(sweets[i].getExpirationTime().getProductionDate().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.ProductionDate.DAY_OF_MONTH =" + sweets[i].getExpirationTime().getProductionDate().get(Calendar.DAY_OF_MONTH));
                writer.write(sweets[i].getExpirationTime().getProductionDate().get(Calendar.DAY_OF_MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.SaveTemperature) =" + sweets[i].getExpirationTime().getSaveTemperature());
                writer.write(sweets[i].getExpirationTime().getSaveTemperature() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.ExpirationTime.YEAR =" + sweets[i].getExpirationTime().getExpirationTime().get(Calendar.YEAR));
                writer.write(sweets[i].getExpirationTime().getExpirationTime().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.ExpirationTime.MONTH =" + sweets[i].getExpirationTime().getExpirationTime().get(Calendar.MONTH));
                writer.write(sweets[i].getExpirationTime().getExpirationTime().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: sweets.ExpirationTime.DAY_OF_MONTH =" + sweets[i].getExpirationTime().getExpirationTime().get(Calendar.DAY_OF_MONTH));
                writer.write(sweets[i].getExpirationTime().getExpirationTime().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightVegetables(Vegetable[] vegetables, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(vegetables.length + "\n");
            for (int i = 0; i < vegetables.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.Id =" + vegetables[i].getId());
                writer.write(vegetables[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.Name =" + vegetables[i].getName());
                writer.write(vegetables[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.Amount =" + vegetables[i].getAmount());
                writer.write(vegetables[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.Description =" + vegetables[i].getDescription());
                writer.write(vegetables[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.Price =" + vegetables[i].getPrice());
                writer.write(vegetables[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.Type =" + vegetables[i].getType());
                writer.write(vegetables[i].getType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.ProductionDate.YEAR =" + vegetables[i].getExpirationTime().getProductionDate().get(Calendar.YEAR));
                writer.write(vegetables[i].getExpirationTime().getProductionDate().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.ProductionDate.MONTH =" + vegetables[i].getExpirationTime().getProductionDate().get(Calendar.MONTH));
                writer.write(vegetables[i].getExpirationTime().getProductionDate().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.ProductionDate.DAY_OF_MONTH =" + vegetables[i].getExpirationTime().getProductionDate().get(Calendar.DAY_OF_MONTH));
                writer.write(vegetables[i].getExpirationTime().getProductionDate().get(Calendar.DAY_OF_MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.SaveTemperature) =" + vegetables[i].getExpirationTime().getSaveTemperature());
                writer.write(vegetables[i].getExpirationTime().getSaveTemperature() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.ExpirationTime.YEAR =" + vegetables[i].getExpirationTime().getExpirationTime().get(Calendar.YEAR));
                writer.write(vegetables[i].getExpirationTime().getExpirationTime().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.ExpirationTime.MONTH =" + vegetables[i].getExpirationTime().getExpirationTime().get(Calendar.MONTH));
                writer.write(vegetables[i].getExpirationTime().getExpirationTime().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: vegetables.ExpirationTime.DAY_OF_MONTH =" + vegetables[i].getExpirationTime().getExpirationTime().get(Calendar.DAY_OF_MONTH));
                writer.write(vegetables[i].getExpirationTime().getExpirationTime().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightComputers(Computer[] computers, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(computers.length + "\n");
            for (int i = 0; i < computers.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Id =" + computers[i].getId());
                writer.write(computers[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Name =" + computers[i].getName());
                writer.write(computers[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Amount =" + computers[i].getAmount());
                writer.write(computers[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Description =" + computers[i].getDescription());
                writer.write(computers[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Price =" + computers[i].getPrice());
                writer.write(computers[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Ram.MemorySize =" + computers[i].getRam().getMemorySize());
                writer.write(computers[i].getRam().getMemorySize() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Ram.MemoryType =" + computers[i].getRam().getMemoryType());
                writer.write(computers[i].getRam().getMemoryType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Cpu.CoreNumber =" + computers[i].getCpu().getCoreNumber());
                writer.write(computers[i].getCpu().getCoreNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Cpu.Frequency =" + computers[i].getCpu().getFrequency());
                writer.write(computers[i].getCpu().getFrequency() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Gpu.CoreNumber =" + computers[i].getVideoCard().getGpu().getCoreNumber());
                writer.write(computers[i].getVideoCard().getGpu().getCoreNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Gpu.Frequency =" + computers[i].getVideoCard().getGpu().getFrequency());
                writer.write(computers[i].getVideoCard().getGpu().getFrequency() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.VideoRAM.MemorySize =" + computers[i].getVideoCard().getVideoRAM().getMemorySize());
                writer.write(computers[i].getVideoCard().getVideoRAM().getMemorySize() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.VideoRAM.MemoryType =" + computers[i].getVideoCard().getVideoRAM().getMemoryType());
                writer.write(computers[i].getVideoCard().getVideoRAM().getMemoryType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Warranty.YEAR =" + computers[i].getWarranty().getWarranty().get(Calendar.YEAR));
                writer.write(computers[i].getWarranty().getWarranty().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Warranty.MONTH =" + computers[i].getWarranty().getWarranty().get(Calendar.MONTH));
                writer.write(computers[i].getWarranty().getWarranty().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: computers.Warranty.DAY_OF_MONTH =" + computers[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH));
                writer.write(computers[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightPhones(Phone[] phones, File path) {
        if (!path.exists() & path.canWrite()) {
            try {
                path.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(path);
            writer.flush();
            writer.write(phones.length + "\n");
            for (int i = 0; i < phones.length; i++) {
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Id =" + phones[i].getId());
                writer.write(phones[i].getId() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Name =" + phones[i].getName());
                writer.write(phones[i].getName() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Amount =" + phones[i].getAmount());
                writer.write(phones[i].getAmount() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Description =" + phones[i].getDescription());
                writer.write(phones[i].getDescription() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Price =" + phones[i].getPrice());
                writer.write(phones[i].getPrice() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.OperatingSystem =" + phones[i].getSystem().getOperatingSystem());
                writer.write(phones[i].getSystem().getOperatingSystem() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Ram.MemorySize =" + phones[i].getRam().getMemorySize());
                writer.write(phones[i].getRam().getMemorySize() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Ram.MemoryType =" + phones[i].getRam().getMemoryType());
                writer.write(phones[i].getRam().getMemoryType() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Cpu.CoreNumber =" + phones[i].getCpu().getCoreNumber());
                writer.write(phones[i].getCpu().getCoreNumber() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Cpu.Frequency =" + phones[i].getCpu().getFrequency());
                writer.write(phones[i].getCpu().getFrequency() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Diagonal() =" + phones[i].getDiagonal().getDiagonal());
                writer.write(phones[i].getDiagonal().getDiagonal() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.WorkOnButtery() =" + phones[i].getWorkingTime().getWorkOnButtery());
                writer.write(phones[i].getWorkingTime().getWorkOnButtery() + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Warrant.YEAR =" + phones[i].getWarranty().getWarranty().get(Calendar.YEAR));
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.YEAR) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Warranty.MONTH =" + phones[i].getWarranty().getWarranty().get(Calendar.MONTH));
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.MONTH) + "\n");
                Logger.INSTANCE.log(LogType.SYSTEM, "write file: phones.Warranty.DAY_OF_MONTH =" + phones[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH));
                writer.write(phones[i].getWarranty().getWarranty().get(Calendar.DAY_OF_MONTH) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }

    private void wrightBalance(double balance, File file) {
        if (!file.exists() & file.canWrite()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.flush();
            Logger.INSTANCE.log(LogType.SYSTEM, "write file: balance =" + balance);
            writer.write(balance + "\n");
            writer.close();
        } catch (IOException e) {
            Logger.INSTANCE.log(LogType.WARNING, "IOException: Файл не знайдено! " + e);
            e.printStackTrace();
        }
    }
}
