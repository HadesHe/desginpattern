package com.hzjytech.hades.desginpattern.visitpattern.kt

/**
 * Created by Hades on 2017/11/25.
 */
interface ReportVisitable{
    fun accept(visitor:ReportVisitor);
}

class FixedPriceContract(val costPerYear:Long):ReportVisitable{
    override fun accept(visitor:ReportVisitor)=visitor.visit(this);

}

class TimeAndMaterialsContract(val costPerHour:Long,val hours:Long):ReportVisitable{
    override fun accept(visitor: ReportVisitor) =visitor.visit(this)

}

class SupportContract(val costPerMonth:Long):ReportVisitable{
    override fun accept(visitor: ReportVisitor) =visitor.visit(this)

}

interface ReportVisitor{
    fun visit(contract: FixedPriceContract)
    fun visit(contract: TimeAndMaterialsContract);
    fun visit(contract: SupportContract)
}

class MonthlyCostReportVisitor(var monthlyCost:Long=0):ReportVisitor{
    override fun visit(contract: FixedPriceContract) {
        monthlyCost+=contract.costPerYear/12
    }

    override fun visit(contract: TimeAndMaterialsContract) {
        monthlyCost+=contract.costPerHour*contract.hours
    }

    override fun visit(contract: SupportContract) {
        monthlyCost+=contract.costPerMonth
    }
}