import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component'
import { NewEmployeeComponent } from './new-employee/new-employee.component';
const routes: Routes = [
  { path: 'employees', component: EmployeesComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'new-employee', component: NewEmployeeComponent},
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'detail/:username', component: EmployeeDetailComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }