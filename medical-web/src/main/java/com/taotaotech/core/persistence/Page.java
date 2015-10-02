package com.taotaotech.core.persistence;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Page<T> implements Serializable {
    private long totalCount; // 总条数
    private int numPerPage = 20; // 每页显示多少条
    private int currentPage = 1; // 当前是第几页

    private String targetType = "navTab"; // navTab或dialog
    private int pageNumShown = 10; // 页标数

    private int first;// 首页索引
    private int last;// 尾页索引
    private int prev;// 上一页索引
    private int next;// 下一页索引

    private boolean firstPage;//是否是第一页
    private boolean lastPage;//是否是最后一页

    private String orderBy = ""; // 标准查询有效， 实例： updatedate desc, name asc

    private List<T> list = new ArrayList<T>();

    /**
     * 构造方法
     * 默认不分页，返回所有数据
     */
    public Page() {
        this.numPerPage = -1;
    }

    public Page(HttpServletRequest request, HttpServletResponse response) {
        this(request, response, -2);
    }

    /**
     * 构造方法
     *
     * @param request
     * @param response
     * @param defaultNumPerPage 如果传递 -1 则为不分页，返回所有数据
     */
    public Page(HttpServletRequest request, HttpServletResponse response, int defaultNumPerPage) {
        String currentPage = request.getParameter("currentPage");
        String numPerPage = request.getParameter("numPerPage");

        if (StringUtils.isNumeric(currentPage)) {
            this.setCurrentPage(Integer.parseInt(currentPage));
        }
        if (StringUtils.isNumeric(numPerPage)) {
            this.setNumPerPage(Integer.parseInt(numPerPage));
        } else if (defaultNumPerPage != -2) {
            this.numPerPage = defaultNumPerPage;
        }

        String orderBy = request.getParameter("orderBy");
        if (StringUtils.isNotBlank(orderBy)){
            this.setOrderBy(orderBy);
        }
    }

    @JsonIgnore
    public PageBounds createPageBounds() {
        PageBounds pageBounds = new PageBounds();
        if (this.numPerPage != -1) {
            pageBounds.setLimit(numPerPage);
        }
        if (this.currentPage != 0) {
            pageBounds.setPage(this.currentPage);
        }

        // 排序
        if (StringUtils.isNotEmpty(this.orderBy)) {
            String[] str= orderBy.split(" ");
            String property = str[0];
            String direction = "ASC";
            if (str.length > 1) {
                direction = str[1];
            }

            List<Order> orderList = new ArrayList<Order>();
            orderList.add(Order.create(property, direction));

            pageBounds.setOrders(orderList);
        }

        pageBounds.setContainsTotalCount(true);

        return pageBounds;
    }

    /**
     * 构造方法
     *
     * @param currentPage 当前页码
     * @param numPerPage  分页大小
     */
    public Page(int currentPage, int numPerPage) {
        this(currentPage, numPerPage, 0);
    }

    /**
     * 构造方法
     *
     * @param currentPage 当前页码
     * @param numPerPage  分页大小
     * @param totalCount  数据条数
     */
    public Page(int currentPage, int numPerPage, long totalCount) {
        this(currentPage, numPerPage, totalCount, new ArrayList<T>());
    }

    /**
     * 构造方法
     *
     * @param currentPage 当前页码
     * @param numPerPage  分页大小
     * @param totalCount  数据条数
     * @param list        本页数据对象列表
     */
    public Page(int currentPage, int numPerPage, long totalCount, List<T> list) {
        this.setTotalCount(totalCount);
        this.setCurrentPage(currentPage);
        this.setNumPerPage(numPerPage);
        this.setList(list);
    }

    /**
     * 构造方法
     *
     * @param currentPage 当前页码
     * @param numPerPage  分页大小
     * @param totalCount  数据条数
     * @param pageList    本页数据对象列表
     */
    public Page(int currentPage, int numPerPage, long totalCount, PageList<T> pageList) {
        this.setTotalCount(totalCount);
        this.setCurrentPage(currentPage);
        this.setNumPerPage(numPerPage);
        this.setList(list);
    }

    /**
     * 初始化参数
     */
    public void initialize() {

        //1
        this.first = 1;

        this.last = (int) (totalCount / (this.numPerPage < 1 ? 20 : this.numPerPage) + first - 1);

        if (this.totalCount % this.numPerPage != 0 || this.last == 0) {
            this.last++;
        }

        if (this.last < this.first) {
            this.last = this.first;
        }

        if (this.currentPage <= 1) {
            this.currentPage = this.first;
        }

        if (this.currentPage >= this.last) {
            this.currentPage = this.last;
            this.lastPage = true;
        }

        if (this.currentPage < this.last - 1) {
            this.next = this.currentPage + 1;
        } else {
            this.next = this.last;
        }

        if (this.currentPage > 1) {
            this.prev = this.currentPage - 1;
        } else {
            this.prev = this.first;
        }

        //2
        if (this.currentPage < this.first) {// 如果当前页小于首页
            this.currentPage = this.first;
        }

        if (this.currentPage > this.last) {// 如果当前页大于尾页
            this.currentPage = this.last;
        }
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        if (numPerPage >= totalCount) {
            this.setCurrentPage(1);
        }
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage <= 0 ? 10 : numPerPage;// > 500 ? 500 : pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageNumShown() {
        return pageNumShown;
    }

    public void setPageNumShown(int pageNumShown) {
        this.pageNumShown = pageNumShown;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        PageList<T> pageList = null;
        try {
            pageList = (PageList<T>) list;
        } catch (ClassCastException e) {

        }
        if (pageList != null) {
            setList(pageList);
        } else {
            this.list = list;
            initialize();
        }
    }

    public void setList(PageList<T> pageList) {
        this.setTotalCount(pageList.getPaginator().getTotalCount());
        this.list = pageList;
        initialize();
    }

    @JsonIgnore
    public int getFirst() {
        return first;
    }

    @JsonIgnore
    public int getLast() {
        return last;
    }

    @JsonIgnore
    public int getPrev() {
        if (isFirstPage()) {
            return currentPage;
        } else {
            return currentPage - 1;
        }
    }

    @JsonIgnore
    public int getNext() {
        if (isLastPage()) {
            return currentPage;
        } else {
            return currentPage + 1;
        }
    }

    @JsonIgnore
    public boolean isFirstPage() {
        return firstPage;
    }

    @JsonIgnore
    public boolean isLastPage() {
        return lastPage;
    }

    /**
     * 获取查询排序字符串
     * @return
     */
    @JsonIgnore
    public String getOrderBy() {
        // SQL过滤，防止注入
        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
                + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        if (sqlPattern.matcher(orderBy).find()) {
            return "";
        }
        return orderBy;
    }

    /**
     * 设置查询排序，标准查询有效， 实例： updatedate desc, name asc
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}