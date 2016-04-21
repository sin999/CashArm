package cashArm.Common.OEntityes.ConstantsNew;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 15.02.14
 * Time: 19:32
 * To change this template use File | Settings | File Templates.
 */
public enum ODomen {
    electrocom(5970),
    e_region(6172),
    compass(6174),
    e_moscow(6270),
    e_kaluga(6271),
    e_ryazan(6272),
    e_rostov(6273),
    e_obninsk(6775),
    e_bataysk(6776),
    test_ryazan(6777),
    e_krasnogorsk(6910),
    eridan(7331),
    e_n_novgorod(12990),
    test(16570),
    e_taganrog(19670),
    e_volgodonsk(19671),
    e_rostov_don(19710),
    test_r(20110),
    e_krasnodar(20571),
    e_zao(20811),
    e_old(22810),
    e_tula(22870),
    e_bryansk(23230),
    e_novorossiysk(26730),
    ttk(29850),
    yaroslavl(30151),
    ulyanovsk(30671),
    samara(31112),
    ufa(31150),
    sterlitamak(31151);
    private double id;
    ODomen(int id){
        this.id=(double)id;
    }
    public double getId(){
        return id;
    }


}
