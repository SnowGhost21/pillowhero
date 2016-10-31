package hackaton2016.pillowhero.commom;

/**
 * Created by diegocunha on 29/10/16.
 */

public interface Presenter<T extends IView> {
    void setView(T view);
}
