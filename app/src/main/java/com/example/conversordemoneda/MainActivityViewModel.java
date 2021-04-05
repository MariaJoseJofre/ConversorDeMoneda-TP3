package com.example.conversordemoneda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> resultadoMutable;

    public LiveData<String> getResultadoMultable(){
        if(resultadoMutable==null){
            resultadoMutable = new MutableLiveData<>();
        }
        return resultadoMutable;
    }

    public void DolarAEuro(String num){

        try{

            double dolar = Double.parseDouble(num);
            double resul = (dolar * 0.85);
            resultadoMutable.setValue(resul+"");
        }
        catch (Exception e)
        {
            resultadoMutable.setValue("No se pudo hacer la conversión");
        }
    }

    public void EuroADolar(String num){

        try{

            double euro = Double.parseDouble(num);
            double resul = (euro * 1.18);
            resultadoMutable.setValue(resul+"");
        } catch (Exception e) {
            resultadoMutable.setValue("No se pudo hacer la conversion");
        }
        }


    }








