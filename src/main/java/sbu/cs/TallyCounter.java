package sbu.cs;

public class TallyCounter implements TallyCounterInterface {


    private int value_Conter;
    @Override
    public void count()
    {
        if(value_Conter < 9999)
            value_Conter += 1;
    }

    @Override
    public int getValue()
    {
        return value_Conter;
    }

    @Override
    public void setValue(int value) throws IllegalValueException
    {
        if(value > 9999 || value < 0)
        {
            throw new
                    IllegalValueException();
        }
        value_Conter = value;
    }
}
