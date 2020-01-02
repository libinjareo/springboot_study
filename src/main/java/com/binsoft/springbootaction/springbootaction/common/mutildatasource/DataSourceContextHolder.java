package com.binsoft.springbootaction.springbootaction.common.mutildatasource;

/**
 * 数据源上下文
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源类型
     *
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    /**
     * 取得数据源类型
     *
     * @return
     */
    public static String getDataSourceType() {
        return contextHolder.get();
    }

    /**
     * 清理数据源
     */
    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
