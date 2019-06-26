package com.yc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yc.model.City;
import com.yc.model.Province;
import com.yc.model.Town;


public class Data {
    public static List<Province> backProvince() {
        Province pro = new Province();
        pro.setId(1);
        pro.setProvince("����");
        Set cities = new HashSet();
        cities.add("֣��");
        cities.add("����");
        pro.setCities(cities);
        List<Province> list = new ArrayList<Province>();
        //pro.setCities(cities);
        list.add(pro);
        return list;
    }

    public static List<City> backCity(int province_id) {
        //ʡ����
        Province pro = new Province();
        pro.setId(1);
        pro.setProvince("����");
        Set cities = new HashSet();
        cities.add("֣��");
        cities.add("����");
        pro.setCities(cities);
        //�ж���
        City city = new City();
        city.setProvince(pro);
        city.setId(11);
        city.setCity("֣��");
        Set towns = new HashSet();
        towns.add("��ˮ��");
        towns.add("������");
        city.setTowns(towns);

        City city1 = new City();
        city1.setProvince(pro);
        city1.setId(12);
        city1.setCity("����");
        Set towns1 = new HashSet();
        towns1.add("ƽԭ��");
        towns1.add("��Ұ��");
        city1.setTowns(towns1);
        List<City> list = new ArrayList<City>();
        list.add(city);
        list.add(city1);
        if (1 == province_id) {
            return list;
        }
        return null;
    }

    public static List<Town> backTown(int id) {
        //ʡ����
        Province pro = new Province();
        pro.setId(1);
        pro.setProvince("����");
        Set cities = new HashSet();
        cities.add("֣��");
        cities.add("����");
        pro.setCities(cities);
        //�ж���
        City city = new City();
        city.setProvince(pro);
        city.setId(11);
        city.setCity("֣��");
        Set towns = new HashSet();
        towns.add("��ˮ��");
        towns.add("������");
        city.setTowns(towns);

        City city1 = new City();
        city1.setProvince(pro);
        city1.setId(12);
        city1.setCity("����");
        Set towns1 = new HashSet();
        towns1.add("ƽԭ��");
        towns1.add("��Ұ��");
        city1.setTowns(towns1);
        //������
        List<Town> list = new ArrayList<Town>();
        Town town = new Town();
        town.setId(111);
        town.setCity(city);
        town.setTown("������");
        Town town1 = new Town();
        town1.setId(111);
        town1.setCity(city);
        town1.setTown("��ˮ��");
        Town town2 = new Town();
        town2.setId(112);
        town2.setCity(city);
        town2.setTown("ƽԭ��");
        Town town3 = new Town();
        town3.setId(112);
        town3.setCity(city);
        town3.setTown("��Ұ��");

        if (11 == id) {
            list.add(town);
            list.add(town1);
            return list;
        }
        if (12 == id) {
            list.add(town2);
            list.add(town3);
            return list;
        }
        return null;
    }

}
