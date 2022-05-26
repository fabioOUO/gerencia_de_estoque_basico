package DIO.gerenciadeestoque.service;


import DIO.gerenciadeestoque.entity.InforTrib;
import DIO.gerenciadeestoque.entity.form.FormInforTrib;

import java.util.List;

public interface ServiceInforTrib {
    InforTrib create(FormInforTrib form);
    InforTrib get(long codigo);
    List<InforTrib> getAll();
    InforTrib delete(InforTrib inforTrib);
    InforTrib update(long codigo, FormInforTrib formUpdate);
}
