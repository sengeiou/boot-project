package net.chenlin.dp.modules.tyb.dao;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.tyb.entity.HandanPaiHangEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HandanPaiHangMapper {

    List<HandanPaiHangEntity> listHandanPaiHang(Page<HandanPaiHangEntity> page, Query search);

    int saveHandanPaiHang(HandanPaiHangEntity handanPaiHang);

    HandanPaiHangEntity getHandanPaiHangById(Long id);

    int updateHandanPaiHang(HandanPaiHangEntity handanPaiHang);

    int batchRemove(Long[] id);
}