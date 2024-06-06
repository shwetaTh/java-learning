public class IncDecController {
    private IncDecModel model;
    public IncDecController(IncDecModel model){
        this.model= model;
    }

    public int increment(){
        int num = model.getNum()+1;
        model.setNum(num);
        return num;
    }

    public int decrement(){
        int num = model.getNum()-1;
        model.setNum(num);
        return num;
    }
}
