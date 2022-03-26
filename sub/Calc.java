package sub;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Calc {

    private LinkedHashMap<String, List<Double>> hashMap = new LinkedHashMap<>();

    public Calc() {
    }

    public void sgeom(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }

            result.add(StatUtils.geometricMean(elems));
        }
        hashMap.put("Среднее геометрическое", result);

    }

    public void arifm(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }

            result.add(StatUtils.mean(elems));
        }
        hashMap.put("Среднее арифметическое", result);
    }

    public void oso(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }

            result.add(Math.sqrt(StatUtils.variance(elems)));
        }
        hashMap.put("Оценка стандартного отклонения", result);
    }


    public void rv(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }
            result.add(StatUtils.max(elems) - StatUtils.min(elems));
        }
        hashMap.put("Размах выборки", result);
    }

    public void koefk(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems1 = new double[column.size()];
            for (int i = 0; i < elems1.length; i++) {
                elems1[i] = column.get(i);
            }
            for (List<Double> columnb : list) {
                if (!columnb.equals(column)) {          //сравниваем колонки по значению
                    double[] elems2 = new double[column.size()];
                    for (int i = 0; i < elems2.length; i++) {
                        elems2[i] = column.get(i);
                    }
                    result.add(new Covariance().covariance(elems1, elems2));
                }


            }
        }
        hashMap.put("Коэффициент ковариации", result);
    }

    public void count(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            result.add((double) column.size());
        }
        hashMap.put("Количество элементов", result);
    }


    public void koefv(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }
            result.add(Math.sqrt(StatUtils.variance(elems)) / Math.abs(StatUtils.mean(elems)));
        }
        hashMap.put("Коэффициент вариации", result);
    }


    public void dint(Excel excel) {

        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }
            result.add(StatUtils.mean(elems) - (new TDistribution(elems.length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(elems))) / Math.sqrt(elems.length));
        }
        hashMap.put("Доверительный интервал (нижний)", result);
    }


    public void dint2(Excel excel) {

        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }
            result.add(StatUtils.mean(elems) + (new TDistribution(elems.length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(elems))) / Math.sqrt(elems.length));
        }
        hashMap.put("Доверительный интервал (ерхний)", result);
    }


    public void od(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }

            result.add(StatUtils.variance(elems));
        }
        hashMap.put("Оценка дисперсии", result);
    }


    public void max(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }

            result.add(StatUtils.max(elems));
        }
        hashMap.put("Максимум", result);
    }


    public void min(Excel excel) {
        ArrayList<Double> result = new ArrayList<>();
        List<List<Double>> list = excel.getlist();
        for (List<Double> column : list) {
            double[] elems = new double[column.size()];
            for (int i = 0; i < elems.length; i++) {
                elems[i] = column.get(i);
            }

            result.add(StatUtils.min(elems));
        }
        hashMap.put("Минимум", result);
    }


    public void calc(Excel excel) {

            sgeom(excel);
            arifm(excel);
            oso(excel);
            rv(excel);
            koefk(excel);
            count(excel);
            koefv(excel);
            dint(excel);
            dint2(excel);
            od(excel);
            max(excel);
            min(excel);

    }


    public LinkedHashMap<String, List<Double>> getHashMap() {
        return this.hashMap;
    }
}