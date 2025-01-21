export interface Option {
  code: string;
  name: string;
}

export interface States {
  [key: string]: Option[];
}

export interface Cities {
  [key: string]: Option[];
}

export const countries: Option[] = [
  { code: 'US', name: 'United States' },
  { code: 'CA', name: 'Canada' },
  { code: 'IN', name: 'India' },
];

export const states: States = {
  US: [
    { code: 'CA', name: 'California' },
    { code: 'NY', name: 'New York' },
  ],
  CA: [
    { code: 'ON', name: 'Ontario' },
    { code: 'QC', name: 'Quebec' },
  ],
  IN: [
    { code: 'AP', name: 'Andhra Pradesh' },
    { code: 'AR', name: 'Arunachal Pradesh' },
    { code: 'AS', name: 'Assam' },
    { code: 'BR', name: 'Bihar' },
    { code: 'CG', name: 'Chhattisgarh' },
    { code: 'GA', name: 'Goa' },
    { code: 'GJ', name: 'Gujarat' },
    { code: 'HR', name: 'Haryana' },
    { code: 'HP', name: 'Himachal Pradesh' },
    { code: 'JH', name: 'Jharkhand' },
    { code: 'KA', name: 'Karnataka' },
    { code: 'KL', name: 'Kerala' },
    { code: 'MP', name: 'Madhya Pradesh' },
    { code: 'MH', name: 'Maharashtra' },
    { code: 'MN', name: 'Manipur' },
    { code: 'ME', name: 'Meghalaya' },
    { code: 'MZ', name: 'Mizoram' },
    { code: 'NL', name: 'Nagaland' },
    { code: 'OD', name: 'Odisha' },
    { code: 'PB', name: 'Punjab' },
    { code: 'RJ', name: 'Rajasthan' },
    { code: 'SK', name: 'Sikkim' },
    { code: 'TN', name: 'Tamil Nadu' },
    { code: 'TS', name: 'Telangana' },
    { code: 'TR', name: 'Tripura' },
    { code: 'UP', name: 'Uttar Pradesh' },
    { code: 'UT', name: 'Uttarakhand' },
    { code: 'WB', name: 'West Bengal' },
  ],
};

export const cities: Cities = {
  AP: [
    { code: 'VIZ', name: 'Visakhapatnam' },
    { code: 'VJA', name: 'Vijayawada' },
  ],
  AR: [
    { code: 'ITAN', name: 'Itanagar' },
  ],
  AS: [
    { code: 'GUW', name: 'Guwahati' },
    { code: 'SIL', name: 'Silchar' },
  ],
  BR: [
    { code: 'PAT', name: 'Patna' },
    { code: 'BHAG', name: 'Bhagalpur' },
  ],
  CG: [
    { code: 'RAIP', name: 'Raipur' },
    { code: 'BIL', name: 'Bilaspur' },
  ],
  GA: [
    { code: 'PAN', name: 'Panaji' },
    { code: 'MARG', name: 'Margao' },
  ],
  GJ: [
    { code: 'AHM', name: 'Ahmedabad' },
    { code: 'SUR', name: 'Surat' },
  ],
  HR: [
    { code: 'FAR', name: 'Faridabad' },
    { code: 'GUR', name: 'Gurgaon' },
  ],
  HP: [
    { code: 'SHIM', name: 'Shimla' },
    { code: 'MAN', name: 'Manali' },
  ],
  JH: [
    { code: 'RAN', name: 'Ranchi' },
    { code: 'JAM', name: 'Jamshedpur' },
  ],
  KA: [
    { code: 'BGL', name: 'Bengaluru' },
    { code: 'MYS', name: 'Mysuru' },
  ],
  KL: [
    { code: 'KOI', name: 'Kochi' },
    { code: 'TVM', name: 'Thiruvananthapuram' },
  ],
  MP: [
    { code: 'BHO', name: 'Bhopal' },
    { code: 'IND', name: 'Indore' },
  ],
  MH: [
    { code: 'MUM', name: 'Mumbai' },
    { code: 'PUN', name: 'Pune' },
  ],
  MN: [
    { code: 'IMPH', name: 'Imphal' },
  ],
  ME: [
    { code: 'SHI', name: 'Shillong' },
  ],
  MZ: [
    { code: 'AIZ', name: 'Aizawl' },
  ],
  NL: [
    { code: 'KOH', name: 'Kohima' },
  ],
  OD: [
    { code: 'BHU', name: 'Bhubaneswar' },
    { code: 'CUT', name: 'Cuttack' },
  ],
  PB: [
    { code: 'CHD', name: 'Chandigarh' },
    { code: 'LUD', name: 'Ludhiana' },
  ],
  RJ: [
    { code: 'JAIP', name: 'Jaipur' },
    { code: 'UDA', name: 'Udaipur' },
  ],
  SK: [
    { code: 'GANG', name: 'Gangtok' },
  ],
  TN: [
    { code: 'CHN', name: 'Chennai' },
    { code: 'COI', name: 'Coimbatore' },
  ],
  TS: [
    { code: 'HYD', name: 'Hyderabad' },
    { code: 'WAR', name: 'Warangal' },
  ],
  TR: [
    { code: 'AGR', name: 'Agartala' },
  ],
  UP: [
    { code: 'LKO', name: 'Lucknow' },
    { code: 'KAN', name: 'Kanpur' },
  ],
  UT: [
    { code: 'DEH', name: 'Dehradun' },
  ],
  WB: [
    { code: 'KOL', name: 'Kolkata' },
    { code: 'SIL', name: 'Siliguri' },
  ],
  CA: [
    { code: 'LA', name: 'Los Angeles' },
    { code: 'SF', name: 'San Francisco' },
  ],
  NY: [
    { code: 'NYC', name: 'New York City' },
    { code: 'BUF', name: 'Buffalo' },
  ],
  ON: [
    { code: 'TOR', name: 'Toronto' },
    { code: 'OTT', name: 'Ottawa' },
  ],
  QC: [
    { code: 'MTL', name: 'Montreal' },
    { code: 'QUE', name: 'Quebec City' },
  ],
};