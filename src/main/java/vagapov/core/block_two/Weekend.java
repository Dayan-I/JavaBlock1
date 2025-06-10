package vagapov.core.block_two;

//Название не менять
enum Weekend {
    MONDAY ("Понедельник", false), TUESDAY("Вторник", false), WEDNESDAY ("Среда", false), THURSDAY ("Четверг", false),
    FRIDAY ("Пятница", false), SATURDAY ("Суббота", true), SUNDAY ("Воскресенье", true);
    public String rusName;
    public boolean isWeekday;
     Weekend(String rusName, boolean isWeekday) {
        this.rusName = rusName;
        this.isWeekday = isWeekday;
    }

    public boolean isWeekend() {
            return isWeekday;
    }



    public String getRusName() {
       return rusName;
    }
}


